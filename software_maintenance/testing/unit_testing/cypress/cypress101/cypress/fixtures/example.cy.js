import example from './example.json'

describe('<example />', () => {
  it('renders', () => {
    // see: https://test-utils.vuejs.org/guide/
    cy.mount(example)
  })
})