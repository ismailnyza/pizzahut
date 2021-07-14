import http from "../http-common";

class deleteService {
  deleteById(params , currentDish){
    return http.post(params.page + "/delete/"+ currentDish)
  }
}
export default new deleteService();
