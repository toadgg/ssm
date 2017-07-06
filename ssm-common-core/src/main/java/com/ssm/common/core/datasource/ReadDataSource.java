package com.ssm.common.core.datasource;

import com.ssm.common.util.EncryptUtils;
import org.apache.commons.dbcp2.BasicDataSource;

public class ReadDataSource extends BasicDataSource {

    private static final long serialVersionUID = 20160117L;

    /**
     * Decrypt Password
     *
     * @param password encrypt password
     */
    @Override
    public void setPassword(String password) {
        try {
            password = EncryptUtils.aesDecrypt(password, EncryptUtils.DEFAULT_KEY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        super.setPassword(password);
    }

}
