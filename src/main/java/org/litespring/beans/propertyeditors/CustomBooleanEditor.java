package org.litespring.beans.propertyeditors;

import org.litespring.beans.TypeMismatchException;
import org.litespring.utils.StringUtils;

import java.beans.PropertyEditorSupport;

public class CustomBooleanEditor extends PropertyEditorSupport {

    public static final String VALUE_TRUE = "true";
    public static final String VALUE_FALSE = "false";

    public static final String VALUE_ON = "on";
    public static final String VALUE_OFF = "off";

    public static final String VALUE_YES = "yes";
    public static final String VALUE_NO = "no";

    public static final String VALUE_1 = "1";
    public static final String VALUE_0 = "0";

    private boolean allowEmpty;

    public CustomBooleanEditor(boolean allowEmpty){
        this.allowEmpty = allowEmpty;
    }

    @Override
    public String getAsText() {
        if (Boolean.TRUE.equals(getValue())) {
            return VALUE_TRUE;
        }
        else if (Boolean.FALSE.equals(getValue())) {
            return VALUE_FALSE;
        }
        else {
            return "";
        }
    }

    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(allowEmpty&&!StringUtils.hasText(value)){
            setValue(null);
        }
        if(VALUE_TRUE.equals(value)||VALUE_ON.equals(value)||VALUE_1.equals(value)||VALUE_YES.equals(value)){
           setValue(Boolean.TRUE);
        }else if(VALUE_FALSE.equals(value)||VALUE_OFF.equals(value)||VALUE_0.equals(value)||VALUE_NO.equals(value)){
           setValue(Boolean.FALSE);
        }else{
            throw new IllegalArgumentException("Invalid boolean value [" + value + "]");
        }
    }
}
