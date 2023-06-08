package by.epamtc.jwd.db.dao;


import by.epamtc.jwd.db.dto.UserDTO;

import java.util.List;

public interface UserDAO {

    public List<UserDTO> getAllUsers();
}
