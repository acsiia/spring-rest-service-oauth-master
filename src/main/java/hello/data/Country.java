package hello.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    @Column(name = "country_en")
    private String countryEn;

    @Column(name = "country_ru")
    private String countryRu;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Profile profile;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getCountryRu() {
        return countryRu;
    }

    public void setCountryRu(String countryRu) {
        this.countryRu = countryRu;
    }
}
