package open.gallery.newjeans.member.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "MEMBERS")
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @OneToMany(mappedBy = "member",
      fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      orphanRemoval = true
  )
  private List<MemberLikeMap> memberLikeMaps;
}
