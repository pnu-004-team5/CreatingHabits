package com.team5.webapi.model;

import javax.persistence.Entity;

@Entity(name = "authorities")
public class Authority {
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_DBA = "ROLE_DBA";

    // private @EmbeddedId AuthorityId id;

    // public Authority(String userName, String role) {
    //     id = new AuthorityId(userName, role);
    // }
}

// @Embeddable 
// @AllArgsConstructor
// @NoArgsConstructor
// class AuthorityId implements Serializable {
//     String userName;
//     @Column
//     String authority;
// }
