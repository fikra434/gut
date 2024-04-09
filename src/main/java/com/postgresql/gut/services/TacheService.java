package com.postgresql.gut.services;

import com.postgresql.gut.DAO.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;
}
