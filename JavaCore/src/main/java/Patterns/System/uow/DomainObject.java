package Patterns.System.uow;

public abstract class DomainObject {

    protected abstract String getKey();

    protected void markNew() {
        UnitOfWork.getCurrent().registerNew(this);
    }
    protected void markClean() {
        UnitOfWork.getCurrent().registerClean(this);
    }
    protected void markDirty() {
        UnitOfWork.getCurrent().registerDirty(this);
    }
    protected void markRemoved() {
        UnitOfWork.getCurrent().registerRemoved(this);
    }
}
