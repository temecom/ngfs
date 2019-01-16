import { JsonApiModelConfig, JsonApiModel, Attribute, HasMany, BelongsTo } from 'angular2-jsonapi';

@JsonApiModelConfig({
    type: 'people'
})

export class Person extends JsonApiModel {

    @Attribute()
    id: string;
    @Attribute()
    givenName: string;
    @Attribute()
    surnam: string;
    // ...
}
