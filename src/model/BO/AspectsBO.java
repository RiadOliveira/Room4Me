package model.BO;

import java.sql.ResultSet;
import java.util.UUID;

import model.DAO.AspectsDAO;
import model.VO.AspectsVO;
import utils.AllowedGender;

public class AspectsBO extends BaseBO<AspectsVO> {
    private static AspectsDAO aspectsDAO = new AspectsDAO();

    public void insert(AspectsVO aspects) throws Exception {
        verifyIsNull(aspects);
        aspectsDAO.insert(aspects);
    }

    public void update(AspectsVO aspects) throws Exception {
        verifyIsNull(aspects);
        if(findById(aspects) == null) {
            throw new Exception("Requested aspects do not exist.");
        }

        aspectsDAO.update(aspects);
    }

    public void delete(AspectsVO aspects) throws Exception {
        verifyIsNull(aspects);
        if(findById(aspects) == null) {
            throw new Exception("Requested aspects do not exist.");
        }

        aspectsDAO.delete(aspects);
    }

    public AspectsVO getEntityFromResultSet(
		ResultSet findedAspectsDB
	) throws Exception {
		AspectsVO findedAspects = new AspectsVO();

		findedAspects.setId(UUID.fromString(findedAspectsDB.getString("id")));
        findedAspects.setBedroomsQuantity(findedAspectsDB.getInt("bedrooms_quantity"));
        findedAspects.setAvailableToDivide(findedAspectsDB.getBoolean("available_to_divide"));
        findedAspects.setCapacity(findedAspectsDB.getInt("capacity"));
        findedAspects.setDescription(findedAspectsDB.getString("description"));

        int allowedGenderValue = findedAspectsDB.getInt("allowed_gender");
        findedAspects.setAllowedGender(AllowedGender.values()[allowedGenderValue]);

		return findedAspects;
	}

    public AspectsVO findById(AspectsVO aspects) {
        try {
            verifyIsNull(aspects);

            ResultSet findedAspectsDB = aspectsDAO.findById(aspects);
            return getEntityFromResultSet(findedAspectsDB);
        } catch (Exception exception) {
            return null;
        }
    }
}