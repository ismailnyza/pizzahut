import http from "../http-common";

class updateService {
  getUpdatedDish(params , currentDish){
    return http.post(params.dishType + "/update"  , currentDish)
  }
}

export default new updateService();
