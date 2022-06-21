package ch.bbzbl.facade;

import java.io.Serializable;
import java.util.List;

import ch.bbzbl.dao.ColourDAO;
import ch.bbzbl.dao.EntityManagerHelper;
import ch.bbzbl.entity.Colour;

public class ColourFacade implements Serializable{
    private static final long serialVersionUID = 1L;

    private ColourDAO colourDAO = new ColourDAO();

    public void createColour(Colour colour) {
        EntityManagerHelper.beginTransaction();
        colourDAO.save(colour);
        EntityManagerHelper.commitAndCloseTransaction();
    }

    public void updateColour(Colour colour) {
        EntityManagerHelper.beginTransaction();
        colourDAO.update(colour);
        //Language persistedLng = languageDAO.find(language.getId());
        //persistedLng.setName(language.getName());
        EntityManagerHelper.commitAndCloseTransaction();
    }

    public void deleteColour(Colour colour) {
        EntityManagerHelper.beginTransaction();
        Colour persistedLng = colourDAO.findReferenceOnly(colour.getId());
       colourDAO.delete(persistedLng);
        EntityManagerHelper.commitAndCloseTransaction();
    }

    public Colour findColour(int colourId) {
        EntityManagerHelper.beginTransaction();
        Colour colour = colourDAO.find(colourId);
        EntityManagerHelper.commitAndCloseTransaction();
        return colour;
    }

    public List<Colour> listAll() {
        EntityManagerHelper.beginTransaction();
        List<Colour> result = colourDAO.findAll();
        EntityManagerHelper.commitAndCloseTransaction();
        return result;
    }
}
