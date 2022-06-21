package ch.bbzbl.converter;


import ch.bbzbl.entity.Colour;
import ch.bbzbl.entity.Language;
import ch.bbzbl.facade.ColourFacade;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Colour.class)
public class ColourConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ColourFacade colFacade = new ColourFacade();
		int colId;

		try {
			colId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a Colour and select it (or use the dropdown)", "Type the name of a Colour and select it (or use the dropdown)"));
		}

		return colFacade.findColour(colId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null) {
			return "";
		}
		Colour col = (Colour) arg2;
		return String.valueOf(col.getId());
	}
}
