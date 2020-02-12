The user must have the choice between several possible actions when he enters on edition on a cell. 
	That's why we developped several celleditors with addition buttons (bug 560094). See classes:
		  ActionComboBoxCellEditor.java
		  IActionCellEditor.java
		  ICellEditorButtonAction.java
		  UnsetCellEditorButtonAction.java
		  ButtonNatCombo.java
		  CompositeCellEditorButtonAction.java (to declare several button on a cell editor)