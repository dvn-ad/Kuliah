package com.supermarket.service;

import java.util.HashSet;
import java.util.Set;

/**
 * Mengelola keanggotaan pelanggan menggunakan Set untuk memastikan ID unik.
 */
public class MembershipRegistry {
    private Set<String> memberIds;

    public MembershipRegistry() {
        this.memberIds = new HashSet<>();
    }

    public boolean registerMember(String memberId) {
        // .add() akan return false jika elemen sudah ada
        return memberIds.add(memberId);
    }

    public boolean isMember(String memberId) {
        return memberIds.contains(memberId);
    }

    public void displayAllMembers() {
        System.out.println("Total anggota terdaftar: " + memberIds.size());
        System.out.println("ID Anggota: " + memberIds);
    }
}