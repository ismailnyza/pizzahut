import http from "../http-common";

class createDishService {
  createDish(params , currentDish){
    return http.post(params.page + "/delete/"+ currentDish)
  }
}
export default new createDishService();
