package model.BO;

import java.util.List;

import model.DAO.ApartmentDAO;
import model.VO.ApartmentVO;

public class ApartmentBO extends BaseBO<ApartmentVO> {
    private static ApartmentDAO<ApartmentVO> apartmentDAO = new ApartmentDAO<ApartmentVO>();

    public void insert(ApartmentVO apartment) throws Exception {
    	  verifyIsNull(apartment);
    	  apartmentDAO.insert(apartment);
    }

    public void update(ApartmentVO apartment) throws Exception {
    	 verifyIsNull(apartment);
         if(findById(apartment) == null) {
             throw new Exception("Requested apartment do not exist.");
         }

         apartmentDAO.update(apartment);
    }

    public void delete(ApartmentVO apartment) throws Exception {
    	 verifyIsNull(apartment);
         if(findById(apartment) == null) {
             throw new Exception("Requested apartment do not exist.");
         }

         apartmentDAO.delete(apartment);
    }

    public List<ApartmentVO> findAll() {
        return null;
    }

    public ApartmentVO findById(ApartmentVO apartment) {
    }
}
