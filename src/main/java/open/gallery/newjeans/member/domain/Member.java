package open.gallery.newjeans.member.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import open.gallery.newjeans.common.BaseEntity;
import org.hibernate.annotations.BatchSize;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Getter
@Table(name = "MEMBERS")
public class Member extends BaseEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @OneToMany(
      mappedBy = "member",
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      orphanRemoval = true
  )
  @BatchSize(size = 100)
  @Builder.Default
  private Set<MemberLikeMap> memberLikeMaps = new HashSet<>();

  @OneToMany(
      mappedBy = "member",
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      orphanRemoval = true
  )
  @BatchSize(size = 100)
  @Builder.Default
  private Set<MemberUploadMap> memberUploadMaps = new HashSet<>();

  void addLikeMap(Long imageId) {
    memberLikeMaps.add(MemberLikeMap.of(this, imageId));
  }

  void removeLikeMap(Long imageId) {
    memberLikeMaps.remove(MemberLikeMap.of(this, imageId));
  }

  void addUploadMap(Long imageId) {
    memberUploadMaps.add(MemberUploadMap.of(this, imageId));
  }

  void removeUploadMap(Long imageId) {
    memberUploadMaps.remove(MemberUploadMap.of(this, imageId));
  }
}