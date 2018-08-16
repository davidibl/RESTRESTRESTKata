package de.lv1871.dms.Vertragsauskunft;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import de.lv1871.dms.Vertragsauskunft.modeltest.Vertrag;

public interface VertragClient {

	@Path("/api/vertrag")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vertrag> getVertraege(@QueryParam("kundennummer") Long kundennummer);
}
