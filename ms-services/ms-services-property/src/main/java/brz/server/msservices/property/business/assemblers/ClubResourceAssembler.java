//package brz.server.msservices.property.business.assemblers;
//
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
//import org.springframework.stereotype.Component;
//
//import brz.autoconfiguration.exceptionhandler.ResourceNotFoundException;
//import brz.server.msservices.property.persistence.entities.Club;
//import brz.server.msservices.property.presentation.controllers.ClubController;
//import brz.server.msservices.property.presentation.dtos.ClubResource;
//
//@Component
//public class ClubResourceAssembler extends ResourceAssemblerSupport<Club, ClubResource>{
//
//	public ClubResourceAssembler() {
//		super(ClubController.class, ClubResource.class);
//	}
//
//	@Override
//	public ClubResource toResource(Club club) {
//		ClubResource clubResource = new ClubResource();
//		
//		mapAttributte(clubResource, club);
//		
//		try {
//			addSelfLink(clubResource);
//		} catch (ResourceNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return clubResource;
//	}
//	
//	private void mapAttributte(ClubResource clubResource, Club club) {
//		clubResource.setClubId(club.getId());
//		clubResource.setDescription(club.getDescription());
//		clubResource.setTitle(club.getTitle());
//	}
//	
//	private void addSelfLink(ClubResource clubResource) throws ResourceNotFoundException{
//		clubResource.add(ControllerLinkBuilder
//					.linkTo(ControllerLinkBuilder
//					.methodOn(ClubController.class)
//					.readbook(clubResource.getClubId()))
//					.withSelfRel());
//
//	}
//	
//	public Club toModelDB(ClubResource clubResource) {
//		Club club = new Club();
//		mapAttributteModelDB(club, clubResource);
//		return club;
//	}
//
//	private void mapAttributteModelDB( Club club, ClubResource clubResource) {
//		club.setId(clubResource.getClubId());
//		club.setDescription(clubResource.getDescription());
//		club.setTitle(clubResource.getTitle());
//		
//		club.setLocations(clubResource.getLocations());
//	}
//	
//}
