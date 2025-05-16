package pl.dmcs.rkotas.service;

import pl.dmcs.rkotas.domain.Address;

import java.util.List;

public interface AddressService {

    public void addAddress(Address address);
    public void editAddress(Address address);
    public List<Address> listAddress();
    public void removeAddress(long id);
    public Address getAddress(long id);

}
