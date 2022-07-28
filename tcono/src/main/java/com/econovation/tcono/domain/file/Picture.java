package com.econovation.tcono.domain.file;

import com.econovation.tcono.domain.BaseTimeEntity;
import com.econovation.tcono.domain.post.Post;
import com.econovation.tcono.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Picture extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PICTURE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;

    private String storeFileName;

    private String uploadFileName;

    @ColumnDefault("false")
    private boolean isDeleted;

    public boolean deleteFile() {
        this.isDeleted = false;
        return false;
    }
}
