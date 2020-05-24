package com.deepexi.service.entity;

import com.deepexi.repo.PermissionRepository;

public class Permission extends DomainEntity<String, PermissionRepository> {
    public Permission(String id, PermissionRepository repo) {
        super(id, repo);
    }
}
