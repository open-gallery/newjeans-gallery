package open.gallery.newjeans.common;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

  @Comment("생성일시")
  @CreatedDate
  @Column(name = "CREATED_AT", updatable = false)
  private LocalDateTime createdAt;

  @Comment("수정일시")
  @LastModifiedDate
  @Column(name = "UPDATED_AT")
  private LocalDateTime updatedAt;

  @Comment("삭제여부")
  @Column(name = "DELETED", columnDefinition = "boolean default false")
  private Boolean deleted;

  @Comment("삭제사유")
  @Column(name = "DELETED_REASON")
  private String deletedReason;
}
