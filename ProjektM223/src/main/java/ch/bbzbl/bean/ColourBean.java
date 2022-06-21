package ch.bbzbl.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.bbzbl.entity.Colour;
import ch.bbzbl.facade.ColourFacade;

@ViewScoped
@ManagedBean(name="colourBean")
public class ColourBean extends AbstractBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Colour colour;
    private List<Colour> colours;
    private ColourFacade colourFacade;

    public ColourFacade getColourFacade() {
        if (colourFacade == null) {
            colourFacade = new ColourFacade();
        }

        return colourFacade;
    }

    public Colour getcolour() {
        if (colour == null) {
            colour = new Colour();
        }

        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void createColour() {
        try {
            getColourFacade().createColour(colour);
            closeDialog();
            displayInfoMessageToUser("Created with success");
            loadColours();
            resetColour();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("A problem occurred while saving. Try again later");
            e.printStackTrace();
        }
    }

    public void updateColour() {
        try {
            getColourFacade().updateColour(colour);
            closeDialog();
            displayInfoMessageToUser("Updated with success");
            loadColours();
            resetColour();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("A problem occurred while updating. Try again later");
            e.printStackTrace();
        }
    }

    public void deleteColour() {
        try {
            getColourFacade().deleteColour(colour);
            closeDialog();
            displayInfoMessageToUser("Deleted with success");
            loadColours();
            resetColour();
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("A problem occurred while removing. Try again later");
            e.printStackTrace();
        }
    }

    public List<Colour> getAllColours() {
        if (colours == null) {
            loadColours();
        }

        return colours;
    }

    private void loadColours() {
        colours = getColourFacade().listAll();
    }

    public void resetColour() {
        colour = new Colour();
    }
}