package com.projet.address;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
@NotNull
private Integer id;
@NotNull
private String homeAddress;
@NotNull
private Integer studentId;

}
