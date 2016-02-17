package be.groept.hibernate.entities.caching;

import java.util.ArrayList;
import java.util.Collection;

public class Description {

	private Long id;

	private Collection<DescriptionTranslation> translations = new ArrayList<DescriptionTranslation>();

	public Long getId() {
		return id;
	}

	public Collection<DescriptionTranslation> getTranslations() {
		return translations;
	}

	public void setTranslations(Collection<DescriptionTranslation> translations) {
		this.translations = translations;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
