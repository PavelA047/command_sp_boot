package com.example.command_sp_boot.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @OneToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @OneToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "chat_id")
    private String chatId;

    public User(String userName, Group group, Role role, String chatId) {
        this.userName = userName;
        this.group = group;
        this.role = role;
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return userName != null && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
