/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */

var svgNS = "http://www.w3.org/2000/svg";

function validate() {
	var elements = document.getElementsByTagName("text");
	for (var i=0; i<elements.length; i++)
		layoutText(elements.item(i))
}

function layoutText(element) {
	var transform = element.getAttribute("transform");
	if (transform == "")
		layoutTextHorizontal(element);
	else
		layoutTextVertical(element);
}

function layoutTextHorizontal(element) {
	var x = +element.getAttribute("x");
	var width = +element.getAttribute("width");
	var height = +element.getAttribute("height");
	var anchor = element.getAttribute("text-anchor");
	var text = element.textContent;

	if (anchor == "middle")
		x = x+width/2;
	else if (anchor == "end")
		x = x+width;

	element.setAttribute("x", x);
	element.setAttribute("dy", "1em");
	
	var fontHeight = 0;
	var bbox = element.getBBox();
	if (bbox!=null) 
		fontHeight = bbox.height;

	if (height == 0)
		height = fontHeight;

	var lines = element.textContent.split('\\n');
	element.textContent = "";
	for(var k=0; k<lines.length && height >= fontHeight; k++)
	{
		var words = lines[k].split(' ');
		                      
		var tspan = document.createElementNS(svgNS, "tspan");
		var text_node = document.createTextNode(words[0]);
		tspan.appendChild(text_node);
		element.appendChild(tspan);
		if (k > 0) {
			tspan.setAttribute("x", x);
			tspan.setAttribute("dy", "1em");
		}
		height = height - fontHeight;

		for(var i=1; i<words.length && height >= fontHeight; i++)
		{
	       	var len = tspan.firstChild.data.length;
			tspan.firstChild.data += " " + words[i];

			if (tspan.getComputedTextLength() > width)
			{
	           	tspan.firstChild.data = tspan.firstChild.data.slice(0, len);

				tspan = document.createElementNS(svgNS, "tspan");
				text_node = document.createTextNode(words[i]);
				tspan.appendChild(text_node);
				element.appendChild(tspan);
				tspan.setAttribute("x", x);
				tspan.setAttribute("dy", "1em");
				height = height - fontHeight;
			}
		}
		
		if (height < fontHeight)
			while (i < words.length)
				tspan.firstChild.data += " " + words[i++];
	}
}

function layoutTextVertical(element) {
	var x = +element.getAttribute("x");
	var y = +element.getAttribute("y");
	var width = +element.getAttribute("width");
	var height = +element.getAttribute("height");
	var anchor = element.getAttribute("text-anchor");
	var text = element.getTextContent();

	if (anchor == "middle")
		y = y+height/2;
	else if (anchor == "end")
		y = y+height;

	element.setAttribute("y", y);
	element.setAttribute("dx", "0.9em");
	element.setAttribute("dy", "0.45em");

	var split = text.split("\\n");
	element.setTextContent("");
	for (var i=0; i<split.length; i++) {
		var tspan = document.createElementNS(svgNS, "tspan");
		tspan.setTextContent(split[i]);
		if (i > 0) {
			tspan.setAttribute("y", y);
			tspan.setAttribute("dx", "1em");
			tspan.setAttribute("dy", "0.5em");
		}
		element.appendChild(tspan);
	}
}
