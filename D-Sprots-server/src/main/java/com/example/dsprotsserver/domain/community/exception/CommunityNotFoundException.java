package com.example.dsprotsserver.domain.community.exception;

import com.example.dsprotsserver.global.error.ErrorCode;
import com.example.dsprotsserver.global.error.exception.CustomException;

public class CommunityNotFoundException extends CustomException {
    public CommunityNotFoundException(){
        super(ErrorCode.COMMUNITY_NOT_FOUND);
    }

}
