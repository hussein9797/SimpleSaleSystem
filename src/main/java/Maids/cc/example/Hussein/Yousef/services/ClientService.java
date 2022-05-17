package Maids.cc.example.Hussein.Yousef.services;

import Maids.cc.example.Hussein.Yousef.Excptions.NotFoundException;
import Maids.cc.example.Hussein.Yousef.dto.requests.addClientRequest;
import Maids.cc.example.Hussein.Yousef.dto.requests.updateClientRequest;
import Maids.cc.example.Hussein.Yousef.models.Client;

import java.util.List;

public interface    ClientService {

    void addClient(addClientRequest addClientRequest);
    void  deleteById(Long clientId) throws NotFoundException;;
    List<Client> getAllClient();
    Client getClientById( Long clientId) throws NotFoundException;
    void updateClientById(updateClientRequest updateClientRequest)throws  NotFoundException;



}
