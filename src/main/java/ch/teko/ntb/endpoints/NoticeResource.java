package ch.teko.ntb.endpoints;

import ch.teko.ntb.business.NoticeManager;
import ch.teko.ntb.model.Notice;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by antic-software-ing on 04.09.2017.
 */

@Path("notice")
public class NoticeResource extends AbstractInjector {

  private NoticeManager noticeManager;

  public NoticeResource() {
    noticeManager = injector.getInstance(NoticeManager.class);
  }

  @GET
  @Path("info")
  public Response getInfo() {
    // http://localhost:8080/rest/hello/get/theMessage
    return Response.status(200).entity("it works...").build();
  }

  @POST
  @Path("addNote")
  public Response addNote(@Valid Notice notice, @HeaderParam("Authorization") String jwtToken) {
    try {
      Notice newNotice = noticeManager.addNote(jwtToken, notice);
      return Response
          .status(201)
          .entity("")
          .header("notice-id", newNotice.getId())
          .build();
    } catch (Exception e) {
      System.err.println("error:" + e.getMessage());
      return Response.status(401).entity("add notice fail!").build();
    }
  }

  @PUT
  @Path("updateNote")
  public Response updateNote(@Valid Notice notice, @HeaderParam("Authorization") String jwtToken) {
    try {
      noticeManager.updateNote(jwtToken, notice);
      return Response
          .status(200)
          .entity("")
          .build();
    } catch (Exception e) {
      System.err.println("error:" + e.getMessage());
      return Response.status(401).entity("change notice fail!").build();
    }
  }

  @DELETE
  @Path("deleteNote/{id}")
  public Response deleteNote(@PathParam("id") int noticeId, @HeaderParam("Authorization") String jwtToken) {
    try {
      noticeManager.deleteNote(jwtToken, noticeId);
      return Response
          .status(200)
          .entity("")
          .build();
    } catch (Exception e) {
      System.err.println("error:" + e.getMessage());
      return Response.status(401).entity("delete notice fail!").build();
    }
  }

}