import http from "../http-common";

class pizzaService {
  getAllPaginated(params) {
    console.log(params.dishType, params.pageSize);
    return http.get(
      params.dishType +
        "/Pagination/" +
        params.page +
        "/" +
        params.pageSize +
        "/" +
        params.sortType
    );
  }

  // updateDish(dishTobeUpdated){
  //   return http.post()
  // }

  // other CRUD methods
}

export default new pizzaService();
