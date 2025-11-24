package ccrm.dao;

import ccrm.model.Offering;
import java.util.*;

public class OfferingRepository {
    private final Map<String, Offering> offeringDatabase;

    public OfferingRepository() {
        this.offeringDatabase = new HashMap<>();
    }

    public void save(Offering offering) {
        if (offering == null) {
            throw new IllegalArgumentException("Offering cannot be null");
        }
        offeringDatabase.put(offering.getOfferingId(), offering);
    }

    public Offering findById(String offeringId) {
        return offeringDatabase.get(offeringId);
    }

    public Collection<Offering> findAll() {
        return offeringDatabase.values();
    }

    public List<Offering> findBySemester(String semester) {
        List<Offering> results = new ArrayList<>();
        for (Offering offering : offeringDatabase.values()) {
            if (offering.getAcademicSemester().equalsIgnoreCase(semester)) {
                results.add(offering);
            }
        }
        return results;
    }

    public void remove(String offeringId) {
        offeringDatabase.remove(offeringId);
    }

    public boolean exists(String offeringId) {
        return offeringDatabase.containsKey(offeringId);
    }
}
