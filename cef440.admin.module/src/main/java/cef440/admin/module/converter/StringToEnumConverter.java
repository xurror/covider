package cef440.admin.module.converter;

import org.springframework.core.convert.converter.Converter;

import com.admin.module.model.user.UserType;

public class StringToEnumConverter implements Converter<String, UserType> {
    @Override
    public UserType convert(String source) {
        try {
            return UserType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}