package id.rakhmad.demo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookProducer producer;

    @POST
    public Response send(Book book) {
        producer.sendBookToKafka(book);
        return Response.accepted().build();
    }

    @Path("random")
    @POST
    public Response seed() {
        producer.sendRandomBookToKafka();
        return Response.accepted().build();
    }

}
