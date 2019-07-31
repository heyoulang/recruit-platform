package io.recruit.common.constant;

public enum TableField {

    createName,

    createTime,

    updateName,

    updateTime,
    
    all;
    
    public static TableField from(String name) {
        
        for (TableField field : TableField.values()) {
            
            if (field.name().equalsIgnoreCase(name)) {
                return field;
            }
        }
        
        return null;
    }
}
