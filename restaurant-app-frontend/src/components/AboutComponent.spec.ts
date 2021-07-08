import { mount } from '@cypress/vue'
import AboutComponent from './AboutComponent.vue'
import './AboutComponent.css'

describe('Render Check', () => {
  it('Renders', () => {
    // mochito ?
    const  propsData = {
      imageLink: "aaa",
      dishID: "dishID",
      dishName: "dishName",
      dishDescription: "dishDesc",
      dishPrice: "dishPrice",
      toppings: "toppings",
    }
    // not now but i will
    mount(AboutComponent, {
     propsData
    })
  }) 
})
