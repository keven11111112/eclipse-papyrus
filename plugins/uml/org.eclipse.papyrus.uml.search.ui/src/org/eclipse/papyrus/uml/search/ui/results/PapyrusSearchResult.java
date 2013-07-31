/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.results;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.views.search.regex.PatternHelper;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.papyrus.views.search.results.ModelElementMatch;
import org.eclipse.papyrus.views.search.results.ModelMatch;
import org.eclipse.papyrus.views.search.results.ViewerMatch;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.papyrus.views.search.utils.MatchUtils;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.IEditorMatchAdapter;
import org.eclipse.search.ui.text.IFileMatchAdapter;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

import com.swtdesigner.ResourceManager;

public class PapyrusSearchResult extends AbstractTextSearchResult implements IEditorMatchAdapter, IFileMatchAdapter {

	MatchFilter[] possibleMatchFilter;

	private AbstractPapyrusQuery searchQuery;

	public PapyrusSearchResult(AbstractPapyrusQuery query) {
		this.searchQuery = query;
		possibleMatchFilter = new MatchFilter[0];
	}

	public AbstractPapyrusQuery getQuery() {
		return searchQuery;
	}


	public void setPossibleMatchFilter(MatchFilter[] possibleMatchFilter) {
		this.possibleMatchFilter = possibleMatchFilter;
	}

	@Override
	public MatchFilter[] getAllMatchFilters() {
		return possibleMatchFilter;

	}

	public String getLabel() {

		return getMatchCount() + Messages.PapyrusSearchResult_0 + searchQuery.getSearchQueryText() + Messages.PapyrusSearchResult_1;
	}

	public String getTooltip() {

		return Messages.PapyrusSearchResult_2;
	}

	public ImageDescriptor getImageDescriptor() {
		return ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/PapyrusSearch.png"); //$NON-NLS-1$
	}

	@Override
	public IEditorMatchAdapter getEditorMatchAdapter() {
		return this;
	}

	@Override
	public IFileMatchAdapter getFileMatchAdapter() {
		return this;
	}

	public Match[] computeContainedMatches(AbstractTextSearchResult result, IFile file) {
		Set<Match> results = new HashSet<Match>();

		Set<AbstractResultEntry> allMatches = MatchUtils.getMatches(result, true);
		for(AbstractResultEntry modelMatch : allMatches) {
			Object element = modelMatch.getElement();
			if(element instanceof ScopeEntry) {
				if(((ScopeEntry)element).getResource().equals(file)) {
					results.add(modelMatch);
				}
			}
		}
		Match[] arrayResult = new Match[results.size()];

		return results.toArray(arrayResult);
	}

	public IFile getFile(Object element) {
		if(element instanceof ScopeEntry) {
			if(((ScopeEntry)element).getResource() instanceof IFile) {
				return (IFile)((ScopeEntry)element).getResource();
			}
		}
		return null;
	}

	public boolean isShownInEditor(Match match, IEditorPart editor) {
		if(match instanceof AbstractResultEntry) {
			Object element = match.getElement();
			if(element instanceof ScopeEntry) {
				((ScopeEntry)element).getResource();

				if(((ScopeEntry)element).getResource().equals(ResourceUtil.getResource(editor.getEditorInput()))) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public Match[] getMatches(Object element) {

		Match[] matchList = super.getMatches(element);
		Set<Match> matchToKeep = new HashSet<Match>();
		List<Object> sourceList = new ArrayList<Object>();
		// Get matches which are still true 
		for(Match match : matchList) {
			if(match instanceof AbstractResultEntry) {
				if(((AbstractResultEntry)match).getSource() != null) {
					if(match instanceof AttributeMatch) {

						String value = null;
						EObject target = (EObject)((AbstractResultEntry)match).getSource();
						if(((AttributeMatch)match).getMetaAttribute() instanceof EAttribute) {

							EAttribute attribute = (EAttribute)((AttributeMatch)match).getMetaAttribute();
							value = String.valueOf(target.eGet(attribute));
						} else if(((AttributeMatch)match).getMetaAttribute() instanceof Property) {

							Property attribute = (Property)((AttributeMatch)match).getMetaAttribute();
							value = (String)((Element)((AbstractResultEntry)match).getSource()).getValue(((AttributeMatch)match).getStereotype(), attribute.getName());


						}
						if(value != null && !this.getQuery().isRegularExpression()) {
							if(value.length() >= match.getOffset() + match.getLength()) {
								value = value.substring(match.getOffset(), match.getLength());
								if(this.searchQuery.isCaseSensitive()) {
									if(value.equals(this.searchQuery.getSearchQueryText())) {
										((AbstractResultEntry)match).recursiveHierarchy((AbstractResultEntry)((AbstractResultEntry)match).getParent());
										matchToKeep.add(match);
										sourceList.add(((AbstractResultEntry)match).getSource());
									}
								} else {
									if(value.equalsIgnoreCase(this.searchQuery.getSearchQueryText())) {

										((AbstractResultEntry)match).recursiveHierarchy((AbstractResultEntry)((AbstractResultEntry)match).getParent());

										matchToKeep.add(match);
										sourceList.add(((AbstractResultEntry)match).getSource());
									}
								}
							}
						} else if(this.getQuery().isRegularExpression()) {
							if(this.getQuery().getSearchQueryText() != null) {


								Pattern pattern = PatternHelper.getInstance().createPattern(this.getQuery().getSearchQueryText(), false, true);
								Matcher m = pattern.matcher(value);
								if(m.matches()) {
									int start = m.start();
									int end = m.end();
									if(start == match.getOffset() && end == match.getOffset() + match.getLength()) {
										matchToKeep.add(match);
										sourceList.add(((AbstractResultEntry)match).getSource());
									}
								}
							}
						}
					} else if(match instanceof ModelElementMatch) {
						((AbstractResultEntry)match).recursiveHierarchy((AbstractResultEntry)match);

						matchToKeep.add(match);
						sourceList.add(((AbstractResultEntry)match).getSource());
					}
				}
			}
		}
		// Now get Viewers
		for(Match match : matchList) {
			if(match instanceof ViewerMatch) {
				Object source = ((ViewerMatch)match).getSemanticElement();
				if(sourceList.contains(source)) {
					matchToKeep.add(match);
				}
			}

		}

		return (Match[])matchToKeep.toArray(new Match[matchToKeep.size()]);

	}

	public Match[] computeContainedMatches(AbstractTextSearchResult result, IEditorPart editor) {
		Set<Object> results = new HashSet<Object>();
		Set<AbstractResultEntry> allMatches = MatchUtils.getMatches(result, true);
		for(AbstractResultEntry modelMatch : allMatches) {
			Object element = modelMatch.getElement();
			if(element instanceof ScopeEntry) {
				if(((ScopeEntry)element).getResource().equals(ResourceUtil.getResource(editor.getEditorInput()))) {
					results.add(modelMatch);
				}
			}
		}

		Match[] arrayResult = new Match[results.size()];

		return results.toArray(arrayResult);
	}

	@Override
	public int getMatchCount() {

		List<Object> elementList = Arrays.asList(this.getElements());
		int count = 0;
		for(Object element : elementList) {

			for(Match match : this.getMatches(element)) {
				if(match instanceof ModelMatch || match instanceof ViewerMatch)
					count++;
			}

		}
		return count;
	}



}
