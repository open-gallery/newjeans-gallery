package open.gallery.newjeans.member.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "MEMBER_LIKE_MAP")
public class MemberLikeMap {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", nullable = false)
  private Long id;

  @ManyToOne
  private Member member;

  @Column(name = "IMAGE_ID", nullable = false)
  private Long imageId;

  public static MemberLikeMap of(Member member, Long imageId) {
    return MemberLikeMap.builder()
        .member(member)
        .imageId(imageId)
        .build();
  }
}
