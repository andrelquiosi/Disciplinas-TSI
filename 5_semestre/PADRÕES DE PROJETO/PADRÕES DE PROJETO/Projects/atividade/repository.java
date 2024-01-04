// class Repository {
//     Entity findById(long id){

//     }
// }

// class Service{
//     Repository repository;

//     Repository getRepository(){
//         return repository;
//     }
// }


// class Context{
//     Service service;

//     void useCase(){
//         Entity entity = service.getRepository().findById(1);
//     }
// }

class Repository {
    Entity findById(long id) {
        // implementação
    }
}

class Service {
    Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
}

class Context {
    Service service;

    public Context(Service service) {
        this.service = service;
    }

    void useCase() {
        Entity entity = service.repository.findById(1);
        // fazer algo com a entidade encontrada
    }
}