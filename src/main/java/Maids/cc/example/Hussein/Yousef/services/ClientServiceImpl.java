package Maids.cc.example.Hussein.Yousef.services;

import Maids.cc.example.Hussein.Yousef.Excptions.NotFoundException;
import Maids.cc.example.Hussein.Yousef.dto.requests.addClientRequest;
import Maids.cc.example.Hussein.Yousef.dto.requests.updateClientRequest;
import Maids.cc.example.Hussein.Yousef.models.Client;
import Maids.cc.example.Hussein.Yousef.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void addClient(addClientRequest addClientRequest) {
        try {
            Client newClient= new Client();
            newClient.setFirstName(addClientRequest.getFirstName());
            newClient.setLastName(addClientRequest.getLastName());
            newClient.setMobilePhone(addClientRequest.getMobilePhone());
            newClient.setCreatedAt(new Date());

            clientRepository.save(newClient);

        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }

    }

    @Override
    public void deleteById(Long clientId) throws NotFoundException {
        try {
            Optional<Client> client =clientRepository.findById(clientId);
            if (client.isPresent()){
                clientRepository.deleteById(clientId);

            }
            else {
                throw new NotFoundException("client does not exist !");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }
    }


    @Override
    public List<Client> getAllClient() {

        return clientRepository.findAll();
    }

    @Override
    public Client getClientById( Long clientId) {
        try {

            Optional<Client> client = clientRepository.findById(clientId);
            if (client.isPresent()){

                return client.get();
            }
            else{

                throw new NotFoundException("Client with this Specific Id not found !");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }

    }

    @Override
    public void updateClientById(updateClientRequest updateClientRequest) throws NotFoundException {
        try {

            Optional<Client> client = clientRepository.findById(updateClientRequest.getId());
            if (client.isPresent()) {
                Client clientToUpdate = client.get();
                clientToUpdate.setFirstName(updateClientRequest.getFirstName());
                clientToUpdate.setLastName(updateClientRequest.getLastName());
                clientToUpdate.setMobilePhone(updateClientRequest.getMobilePhone());
                clientRepository.save(clientToUpdate);
            }
            else {
                throw  new NotFoundException("can't update ,this client does not exist ! ");
            }

        }catch (Exception e){

            e.printStackTrace();
            throw  e;

        }

    }
}
