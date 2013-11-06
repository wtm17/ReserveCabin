package reservecabin

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException

class CabinController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        [cabinInstanceList: Cabin.list(params), cabinInstanceTotal: Cabin.count()]
        def cabinInstanceList = Cabin.list(params)
        render cabinInstanceList as JSON
    }

    def create() {
        [cabinInstance: new Cabin(params)]
    }

    def save() {
        def cabinInstance = new Cabin(params)
        if (!cabinInstance.save(flush: true)) {
            render(view: "create", model: [cabinInstance: cabinInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'cabin.label', default: 'Cabin'), cabinInstance.id])
        redirect(action: "show", id: cabinInstance.id)
    }

    def show(Long id) {
        def cabinInstance = Cabin.get(id)
        if (!cabinInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cabin.label', default: 'Cabin'), id])
            redirect(action: "list")
            return
        }

        [cabinInstance: cabinInstance]
    }

    def edit(Long id) {
        def cabinInstance = Cabin.get(id)
        if (!cabinInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cabin.label', default: 'Cabin'), id])
            redirect(action: "list")
            return
        }

        [cabinInstance: cabinInstance]
    }

    def update(Long id, Long version) {
        def cabinInstance = Cabin.get(id)
        if (!cabinInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cabin.label', default: 'Cabin'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (cabinInstance.version > version) {
                cabinInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'cabin.label', default: 'Cabin')] as Object[],
                          "Another user has updated this Cabin while you were editing")
                render(view: "edit", model: [cabinInstance: cabinInstance])
                return
            }
        }

        cabinInstance.properties = params

        if (!cabinInstance.save(flush: true)) {
            render(view: "edit", model: [cabinInstance: cabinInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'cabin.label', default: 'Cabin'), cabinInstance.id])
        redirect(action: "show", id: cabinInstance.id)
    }

    def delete(Long id) {
        def cabinInstance = Cabin.get(id)
        if (!cabinInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cabin.label', default: 'Cabin'), id])
            redirect(action: "list")
            return
        }

        try {
            cabinInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'cabin.label', default: 'Cabin'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cabin.label', default: 'Cabin'), id])
            redirect(action: "show", id: id)
        }
    }
}
