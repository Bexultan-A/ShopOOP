package com.company.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DDD {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
