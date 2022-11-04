package com.montella.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "Name",
                column = @Column(name="guardian_name")
        ),
        @AttributeOverride(
                name = "Email",
                column = @Column(name = "guardian_email")
        )
}

)
public class Guardian {
    private String Mobile;
    private String Email;

}
