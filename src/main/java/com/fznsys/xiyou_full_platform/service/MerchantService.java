package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface MerchantService {
    ArrayList<Merchant> getlistAll();

    void insertMerchant(Merchant merchant);

    void deleteMerchant(String id);

    Merchant getMerchantById(String id);
}
