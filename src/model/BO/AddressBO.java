package model.BO;

import java.sql.ResultSet;
import java.util.UUID;

import model.DAO.AddressDAO;
import model.VO.AddressVO;

public class AddressBO extends BaseBO<AddressVO> {
    private static AddressDAO addressDAO = new AddressDAO();

    public void insert(AddressVO address) throws Exception {
        verifyIsNull(address);
        addressDAO.insert(address);
    }

    public void update(AddressVO address) throws Exception {
        verifyIsNull(address);
        if(findById(address) == null) {
            throw new Exception("Requested address do not exist.");
        }

        addressDAO.update(address);
    }

    public void delete(AddressVO address) throws Exception {
        verifyIsNull(address);
        if(findById(address) == null) {
            throw new Exception("Requested address do not exist.");
        }

        addressDAO.delete(address);
    }

    public AddressVO getEntityFromResultSet(
		ResultSet findedAddressDB
	) throws Exception {
		AddressVO findedAddress = new AddressVO();

		findedAddress.setId(UUID.fromString(findedAddressDB.getString("id")));
        findedAddress.setState(findedAddressDB.getString("state"));
		findedAddress.setCity(findedAddressDB.getString("city"));
		findedAddress.setDistrict(findedAddressDB.getString("district"));
		findedAddress.setStreet(findedAddressDB.getString("street"));
		findedAddress.setComplement(findedAddressDB.getString("complement"));
		findedAddress.setApartmentNumber(findedAddressDB.getString("apartment_number"));
		findedAddress.setZipCode(findedAddressDB.getInt("zip_code"));

		return findedAddress;
	}

    public AddressVO findById(AddressVO address) {
        try {
            verifyIsNull(address);

            ResultSet findedAddressDB = addressDAO.findById(address);
            return getEntityFromResultSet(findedAddressDB);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
