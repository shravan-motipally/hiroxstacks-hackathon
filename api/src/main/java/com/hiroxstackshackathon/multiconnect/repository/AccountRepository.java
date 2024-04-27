package com.hiroxstackshackathon.multiconnect.repository;

import com.hiroxstackshackathon.multiconnect.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {
}
