package com.ssm.common.base.enums;

import com.ssm.common.base.util.Constant;

/**
 * @author Gavin
 * @see org.springframework.core.env.AbstractEnvironment#ACTIVE_PROFILES_PROPERTY_NAME
 */
public enum PhaseEnv {

    ENV_DEV(Constant.ENV_DEV),
    ENV_PROD(Constant.ENV_PROD);

    private final String value;

    PhaseEnv(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
