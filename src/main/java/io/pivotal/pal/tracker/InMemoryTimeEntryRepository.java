package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private List<TimeEntry> timeEntries;

    public InMemoryTimeEntryRepository() {
        this.timeEntries = new ArrayList<>();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newEntry = new TimeEntry(list().size() + 1, timeEntry);
        timeEntries.add(newEntry);
        return newEntry;
    }

    @Override
    public TimeEntry find(long id) {
        Optional<TimeEntry> entry = timeEntries.stream().filter(timeEntry -> timeEntry.getId() == id).findFirst();
        return entry.isPresent() ? entry.get() : null;
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntries;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry currentEntry = find(id);
        if(currentEntry != null) {
            return currentEntry.update(timeEntry);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        TimeEntry currentEntry = find(id);
        if(currentEntry != null) {
            timeEntries.remove(currentEntry);
        }
    }
}
