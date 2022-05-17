package Maids.cc.example.Hussein.Yousef.controllers.ClientManagmentController;


import Maids.cc.example.Hussein.Yousef.dto.requests.addClientRequest;
import Maids.cc.example.Hussein.Yousef.dto.requests.updateClientRequest;
import Maids.cc.example.Hussein.Yousef.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    ClientService clientService;


    @PostMapping(value = "/add_client")
    public ResponseEntity<Object> addClient(@RequestBody addClientRequest addClientRequest) {

        try {

            clientService.addClient(addClientRequest);
            return new ResponseEntity<>("{ \"message\": \"client added successfully \" }", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }


    }


    @PutMapping(value = "/update_client")
    public ResponseEntity<Object> updateClientById(@RequestBody updateClientRequest updateClientRequest)  {

        try {
            clientService.updateClientById(updateClientRequest);
            return new ResponseEntity<>("{ \"message\": \"client updated successfully \" }", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping(value = "/delete_client/{client_id}")
    public ResponseEntity<Object> deleteClientById(@PathVariable ("client_id") Long id)  {

        try {

            clientService.deleteById(id);
            return new ResponseEntity<>("{ \"message\": \"client deleted  successfully \" }", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(value = "/get_allClients")
    public   ResponseEntity<Object> getAllClient() {

        try {

            return new ResponseEntity<>(clientService.getAllClient(), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }


    @GetMapping(value = "/get_client/{client_id}")
     public ResponseEntity<Object> getClientById(@PathVariable("client_id") Long id) {

        try {
            return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }






}
