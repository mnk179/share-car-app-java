// @flow
import { TripService } from "./TripService";
import { fetchData } from "../utils/apiUtils";

const API_URL = "http://localhost:9001/api";

const buildUrl = (path: string) => API_URL + path;

export class RestTripService implements TripService {
    async getAll(): Promise<Trip[]> {
        const data: ApiResponse<Trip[]> = await fetchData("GET", buildUrl("/trips"));
        if (data.isError) {
            throw new Error(); // TODO: better error handling
        }
        return data.value;
    }
    
    asumc getSingle() 
}