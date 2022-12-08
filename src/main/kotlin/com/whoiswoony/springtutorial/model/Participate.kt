package com.whoiswoony.springtutorial.model

import java.io.Serializable
import javax.persistence.*

@Embeddable
data class ParticipatePk(
    @ManyToOne
    @JoinColumn(name="user_id")
    val user: User,
    @ManyToOne
    @JoinColumn(name="space_id")
    val space: Space
): Serializable

@Entity
@Table(name="PARTICIPATE")
class Participate(
    @EmbeddedId
    val participatePk: ParticipatePk
)
